package com.ayocrazy.easystage.view;

import com.ayocrazy.easystage.bean.StageBean;
import com.ayocrazy.easystage.ui.UICreator;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

/**
 * Created by ayo on 2017/1/11.
 */

public class StageWindow extends Window {
    StageBean stageBean;
    private ScrollPane sp;
    private UICreator creator;

    public StageWindow(String title, Skin skin) {
        super(title, skin);
        creator = new UICreator(skin);
        creator.pad(0, 15, 0, 15);
        creator.left().top();
        sp = new ScrollPane(creator, skin);
        sp.setupOverscroll(20, 20, 80);
        sp.setFlickScroll(false);
        sp.setFlingTime(0.6f);
        add(sp).pad(3).expand().fill();
        setResizable(true);
        setResizeBorder(10);
    }

    public void setStageBean(StageBean bean) {
        if (bean == null) return;
        this.stageBean = bean;
        getTitleLabel().setText(bean.getName());
        creator.update(bean);
    }
}
