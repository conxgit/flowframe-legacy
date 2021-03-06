package org.flowframe.ui.vaadin.common.editors.mvp.editor.grid.view;

import org.flowframe.ui.vaadin.common.editors.entity.ext.table.EntityEditorGrid;
import org.flowframe.ui.vaadin.common.editors.entity.ext.table.EntityEditorGrid.IEditListener;
import org.flowframe.ui.vaadin.common.editors.entity.ext.table.EntityEditorGrid.ISelectListener;
import org.vaadin.mvp.uibinder.annotation.UiField;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.ui.VerticalLayout;

public class EditorGridView extends VerticalLayout implements IEditorGridView {
	private static final long serialVersionUID = 1L;

	@UiField
	VerticalLayout mainLayout;

	private EntityEditorGrid grid;

	public EditorGridView() {
		setSizeFull();
	}

	@Override
	public void setContainerDataSource(Container container) {
		grid.setContainerDataSource(container);
	}

	@Override
	public void init() {
		if (mainLayout != null) {
			this.grid = new EntityEditorGrid();
			mainLayout.removeAllComponents();
			mainLayout.addComponent(grid);
			mainLayout.setExpandRatio(grid, 1.0f);
		}
	}

	@Override
	public void setVisibleColumns(Object[] columnIds) {
		this.grid.setVisibleColumns(columnIds);
	}

	@Override
	public void addEditListener(IEditListener listener) {
		this.grid.addEditListener(listener);
	}

	@Override
	public void addSelectListener(ISelectListener listener) {
		this.grid.addSelectListener(listener);
	}

	@Override
	public void deleteItem(Item item) throws Exception {
		this.grid.deleteItem(item);
	}
}
