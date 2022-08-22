package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class OperationTypeControllerImpl extends SpecificController.AbstractImpl<OperationType> implements OperationTypeController,Serializable {

	@Override
	protected Class<OperationType> getEntityClass() {
		return OperationType.class;
	}

}