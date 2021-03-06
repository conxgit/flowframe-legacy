package org.flowframe.ui.vaadin.common.editors.mvp;

import org.vaadin.mvp.eventbus.EventBus;
import org.vaadin.mvp.eventbus.annotation.Event;

import org.flowframe.ui.vaadin.common.editors.mvp.lineeditor.EntityLineEditorPresenter;
import com.vaadin.data.Item;

public interface PageEventBus extends EventBus {
	@Event(handlers = { EntityLineEditorPresenter.class })
	public void setItemDataSource(Item item);
}
