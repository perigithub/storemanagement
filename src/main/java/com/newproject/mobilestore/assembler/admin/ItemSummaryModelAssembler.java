package com.newproject.mobilestore.assembler.admin;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.newproject.mobilestore.controllers.admin.ItemController;
import com.newproject.mobilestore.controllers.admin.ItemSummaryController;
import com.newproject.mobilestore.models.admin.ItemSummary;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ItemSummaryModelAssembler implements RepresentationModelAssembler<ItemSummary, EntityModel<ItemSummary>> {

    @Override
    public EntityModel<ItemSummary> toModel(ItemSummary itemSummary) {
        return EntityModel.of(
                itemSummary,
                linkTo(methodOn(ItemSummaryController.class).getItemSummary()).withSelfRel(),
                linkTo(methodOn(ItemController.class).getItems()).withRel("items")
        );
    }
}

