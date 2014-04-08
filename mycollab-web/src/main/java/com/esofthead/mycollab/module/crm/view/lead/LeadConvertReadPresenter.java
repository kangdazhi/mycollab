/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.crm.view.lead;

import com.esofthead.mycollab.common.localization.GenericI18Enum;
import com.esofthead.mycollab.core.arguments.NumberSearchField;
import com.esofthead.mycollab.core.utils.LocalizationHelper;
import com.esofthead.mycollab.eventmanager.EventBus;
import com.esofthead.mycollab.module.crm.CrmLinkGenerator;
import com.esofthead.mycollab.module.crm.domain.SimpleLead;
import com.esofthead.mycollab.module.crm.domain.criteria.LeadSearchCriteria;
import com.esofthead.mycollab.module.crm.events.LeadEvent;
import com.esofthead.mycollab.module.crm.localization.CrmCommonI18nEnum;
import com.esofthead.mycollab.module.crm.service.LeadService;
import com.esofthead.mycollab.module.crm.view.CrmGenericPresenter;
import com.esofthead.mycollab.module.crm.view.CrmToolbar;
import com.esofthead.mycollab.security.RolePermissionCollections;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.events.DefaultPreviewFormHandler;
import com.esofthead.mycollab.vaadin.mvp.ScreenData;
import com.esofthead.mycollab.vaadin.mvp.ViewManager;
import com.esofthead.mycollab.vaadin.ui.NotificationUtil;
import com.vaadin.ui.ComponentContainer;

/**
 * 
 * @author MyCollab Ltd.
 * @since 3.0
 * 
 */
public class LeadConvertReadPresenter extends
		CrmGenericPresenter<LeadConvertReadView> {
	private static final long serialVersionUID = 1L;

	public LeadConvertReadPresenter() {
		super(LeadConvertReadView.class);
	}

	@Override
	protected void postInitView() {
		view.getPreviewFormHandlers().addFormHandler(
				new DefaultPreviewFormHandler<SimpleLead>() {
					@Override
					public void onCancel() {
						EventBus.getInstance().fireEvent(
								new LeadEvent.GotoList(this, null));
					}

					@Override
					public void gotoNext(SimpleLead data) {
						LeadService contactService = ApplicationContextUtil
								.getSpringBean(LeadService.class);
						LeadSearchCriteria criteria = new LeadSearchCriteria();
						criteria.setSaccountid(new NumberSearchField(AppContext
								.getAccountId()));
						criteria.setId(new NumberSearchField(data.getId(),
								NumberSearchField.GREATER));
						Integer nextId = contactService
								.getNextItemKey(criteria);
						if (nextId != null) {
							EventBus.getInstance().fireEvent(
									new LeadEvent.GotoRead(this, nextId));
						} else {
							NotificationUtil.showGotoLastRecordNotification();
						}
					}

					@Override
					public void gotoPrevious(SimpleLead data) {
						LeadService contactService = ApplicationContextUtil
								.getSpringBean(LeadService.class);
						LeadSearchCriteria criteria = new LeadSearchCriteria();
						criteria.setSaccountid(new NumberSearchField(AppContext
								.getAccountId()));
						criteria.setId(new NumberSearchField(data.getId(),
								NumberSearchField.LESSTHAN));
						Integer nextId = contactService
								.getPreviousItemKey(criteria);
						if (nextId != null) {
							EventBus.getInstance().fireEvent(
									new LeadEvent.GotoRead(this, nextId));
						} else {
							NotificationUtil.showGotoFirstRecordNotification();
						}
					}
				});
	}

	@Override
	protected void onGo(ComponentContainer container, ScreenData<?> data) {
		if (AppContext.canRead(RolePermissionCollections.CRM_LEAD)) {
			CrmToolbar crmToolbar = ViewManager.getView(CrmToolbar.class);
			crmToolbar.gotoItem(LocalizationHelper
					.getMessage(CrmCommonI18nEnum.TOOLBAR_LEADS_HEADER));
			if (data.getParams() instanceof SimpleLead) {
			SimpleLead lead = (SimpleLead) data.getParams();
			super.onGo(container, data);
			view.previewItem(lead);

			AppContext.addFragment(CrmLinkGenerator
					.generateLeadPreviewLink(lead.getId()), LocalizationHelper
					.getMessage(GenericI18Enum.BROWSER_PREVIEW_ITEM_TITLE,
							"Lead", lead.getLeadName()));
			}
		} else {
			NotificationUtil.showMessagePermissionAlert();
		}
	}
}