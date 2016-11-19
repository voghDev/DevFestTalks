package com.devfestgrx.talks.ui.renderer;

import android.content.Context;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by olmo on 19/11/16.
 */

public class ListEntityRendererBuilder extends RendererBuilder<ListEntity> {
    public ListEntityRendererBuilder(Context context, ListEntityRenderer.OnRowClicked onClickListener) {
        Collection<Renderer<ListEntity>> prototypes = getPrototypes(context, onClickListener);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(ListEntity content) {
        return ListEntityRenderer.class;
    }

    private List<Renderer<ListEntity>> getPrototypes(Context context, ListEntityRenderer.OnRowClicked onRowClicked) {
        List<Renderer<ListEntity>> prototypes = new LinkedList<Renderer<ListEntity>>();

        ListEntityRenderer renderer = new TalkRenderer(context, onRowClicked);
        prototypes.add(renderer);

        return prototypes;
    }
}
