package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ActivityControllerImpl extends SpecificController.AbstractImpl<Activity> implements ActivityController,Serializable {

	@Override
	protected Class<Activity> getEntityClass() {
		return Activity.class;
	}

}