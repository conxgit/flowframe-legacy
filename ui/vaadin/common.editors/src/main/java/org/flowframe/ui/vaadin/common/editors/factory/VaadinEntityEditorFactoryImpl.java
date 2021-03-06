package org.flowframe.ui.vaadin.common.editors.factory;

import java.util.Map;

import org.flowframe.documentlibrary.remote.services.IRemoteDocumentRepository;
import org.flowframe.ui.component.domain.AbstractComponent;
import org.flowframe.ui.services.contribution.IComponentFactoryContributionManager;
import org.flowframe.ui.services.data.IEditorDataManager;
import org.flowframe.ui.services.factory.IComponentFactory;
import org.flowframe.ui.services.factory.IComponentModelFactory;
import org.flowframe.ui.vaadin.common.editors.entity.mvp.ConfigurablePresenterFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.vaadin.mvp.eventbus.EventBus;
import org.vaadin.mvp.presenter.IPresenter;

@Transactional
@Repository
public class VaadinEntityEditorFactoryImpl implements IComponentModelFactory {

	@SuppressWarnings("unused")
	protected IRemoteDocumentRepository remoteDocumentRepository;

	protected ConfigurablePresenterFactory factory;

	private IComponentFactoryContributionManager componentFactoryContributionManager;

	public VaadinEntityEditorFactoryImpl() {
	}

	public VaadinEntityEditorFactoryImpl(IComponentFactoryContributionManager componentFactoryContributionManager, ConfigurablePresenterFactory factory) {
		this.factory = factory;
		this.componentFactoryContributionManager = componentFactoryContributionManager;
	}
	
	@Override
	public Map<IPresenter<?, ? extends EventBus>, EventBus> create(AbstractComponent componentModel, Map<String, Object> params) {
		Map<IPresenter<?, ? extends EventBus>, EventBus> res = null;

/*		if (this.componentFactoryContributionManager.getComponentFactoryContributionsMap().containsKey(componentModel.getClass())) {
			final IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(this.componentFactoryContributionManager.getComponentFactoryContributionsMap().get(componentModel.getClass()));
			final EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);			
		} 
		else if (componentModel instanceof AttachmentEditorComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			final IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(AttachmentEditorPresenter.class);
			final EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof NoteEditorComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(NotesEditorPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof PreferencesEditorComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(PreferencesEditorPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof ReferenceNumberEditorComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(ReferenceNumberEditorPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof MasterDetailComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			ConfigurablePresenterFactory presenterFactory = null;
			EventBusManager ebm = (EventBusManager) params.get(IComponentFactory.FACTORY_PARAM_MVP_EVENTBUS_MANAGER);

			if (params.containsKey(IComponentFactory.FACTORY_PARAM_MVP_PRESENTER_FACTORY)) {
				presenterFactory = (ConfigurablePresenterFactory) params.get(IComponentFactory.FACTORY_PARAM_MVP_PRESENTER_FACTORY);
			} else {
				ebm = (EventBusManager) params.get(IComponentFactory.FACTORY_PARAM_MVP_EVENTBUS_MANAGER);
				Locale locale = (Locale) params.get(IComponentFactory.FACTORY_PARAM_MVP_LOCALE);
				presenterFactory = new ConfigurablePresenterFactory(ebm, locale);
				presenterFactory.setCustomizer(new ConfigurablePresenterFactoryCustomizer(params));
				params.put(IComponentFactory.FACTORY_PARAM_MVP_PRESENTER_FACTORY, presenterFactory);
			}

			final IPresenter<?, ? extends EventBus> mainPresenter = presenterFactory.createPresenter(MultiLevelEntityEditorPresenter.class);
			final MultiLevelEntityEditorEventBus mainEventBus = (MultiLevelEntityEditorEventBus) mainPresenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(mainPresenter, mainEventBus);
		} else if (componentModel instanceof DetailFormComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityFormPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof CollapseableSectionFormComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityLineEditorCollapsibleFormPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof SimpleFormComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityLineEditorSimpleFormPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof DetailGridComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityLineEditorGridPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		} else if (componentModel instanceof GridComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityGridPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		}  else if (componentModel instanceof LineEditorComponent) {
			params.put(IComponentFactory.FACTORY_PARAM_MVP_COMPONENT_MODEL, componentModel);
			IPresenter<?, ? extends EventBus> presenter = factory.createPresenter(EntityLineEditorSectionPresenter.class);
			EventBus eventBus = presenter.getEventBus();

			res = new HashMap<IPresenter<?, ? extends EventBus>, EventBus>();
			res.put(presenter, eventBus);
		}*/
		return res;
	}

	public void setRemoteDocumentRepository(IRemoteDocumentRepository remoteDocumentRepository) {
		this.remoteDocumentRepository = remoteDocumentRepository;
	}

	@Override
	public IPresenter<?, ? extends EventBus> createPresenter(AbstractComponent componentModel, Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPresenter<?, ? extends EventBus> createMasterSectionHeaderPresenter(AbstractComponent componentModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPresenter<?, ? extends EventBus> createMasterSectionContentPresenter(AbstractComponent componentModel, Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPresenter<?, ? extends EventBus> createLineEditorSectionContentPresenter(AbstractComponent componentModel, Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPresenter<?, ? extends EventBus> createLineEditorSectionHeaderPresenter(AbstractComponent componentModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean correspondsToPresenter(AbstractComponent componentModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getPresenterFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorDataManager getDataManager() {
		// TODO Auto-generated method stub
		return null;
	}
}
