package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ActControllerImpl extends SpecificController.AbstractImpl<Act> implements ActController,Serializable {

	@Override
	protected Class<Act> getEntityClass() {
		return Act.class;
	}

}