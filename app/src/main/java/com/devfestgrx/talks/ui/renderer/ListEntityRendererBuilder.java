package com.devfestgrx.talks.ui.renderer;

import android.content.Context;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by olmo on 19/11/16.
 */

public class ListEntityRendererBuilder extends RendererBuilder<ListEntity> {
    Map<String, Class> renderers = new HashMap<>();

    public ListEntityRendererBuilder(Context context,
                                     ListEntityRenderer.OnRowClicked onClickListener) {
        List<Renderer<ListEntity>> prototypes = getPrototypes(context, onClickListener);
        setPrototypes(prototypes);
    }

    @Override
    protected Class getPrototypeClass(ListEntity content) {
        return renderers.containsKey(content.getClass().getName())
                ? renderers.get(content.getClass().getName()) : TalkRenderer.class;
    }

    private List<Renderer<ListEntity>> getPrototypes(Context context,
                                                     ListEntityRenderer.OnRowClicked onRowClicked) {
        List<Renderer<ListEntity>> prototypes = new LinkedList<Renderer<ListEntity>>();

        ListEntityRenderer pr = new TalkRenderer(context, onRowClicked);
        prototypes.add(pr);

        registerRenderer(TalkListEntity.class.getName(), TalkRenderer.class);

        return prototypes;
    }

    protected void registerRenderer(String renderableClassName, Class rendererClass) {
        renderers.put(renderableClassName, rendererClass);
    }

    public static class EmptyListener implements ListEntityRenderer.OnRowClicked {
        public void onRowBackgroundClicked(ListEntity i) {
        }

        public void onWidget1Clicked(ListEntity i) {
        }

        public void onWidget2Clicked(ListEntity i) {
        }

        public void onWidget3Clicked(ListEntity i) {
        }

        public void onWidget4Clicked(ListEntity i) {
        }

        public void onWidget5Clicked(ListEntity i) {
        }
    }
}
