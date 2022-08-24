package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ActTypeControllerImpl extends SpecificController.AbstractImpl<ActType> implements ActTypeController,Serializable {

	@Override
	protected Class<ActType> getEntityClass() {
		return ActType.class;
	}

}