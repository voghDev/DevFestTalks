package com.devfestgrx.talks.ui.renderer;

import android.content.Context;
import android.view.View;

import com.pedrogomez.renderers.Renderer;

import butterknife.ButterKnife;

/**
 * Created by olmo on 19/11/16.
 */
public abstract class ListEntityRenderer extends Renderer<ListEntity> {
    protected Context context;
    protected OnRowClicked listener = new EmptyListener();

    public interface OnRowClicked {
        void onRowBackgroundClicked(ListEntity i);

        /* Estos elementos de lista son genéricos; Van a usarse para renderizar muchas entidades.
         * Estos métodos se usan para gestionar los clicks de los distintos widgets que haya
         * En sus rows (botones, thumbnails, textos...)
         */
        void onWidget1Clicked(ListEntity i);

        void onWidget2Clicked(ListEntity i);

        void onWidget3Clicked(ListEntity i);

        void onWidget4Clicked(ListEntity i);

        void onWidget5Clicked(ListEntity i);
    }

    public static class EmptyListener implements OnRowClicked {
        public void onRowBackgroundClicked(ListEntity i) { /* Empty */ }

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

    @Override
    protected void setUpView(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    @Override
    public abstract void render();

    public void setListener(OnRowClicked listener) {
        if (listener != null) {
            this.listener = listener;
        }
    }
}
