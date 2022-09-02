package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class OperationStatusControllerImpl extends SpecificController.AbstractImpl<OperationStatus> implements OperationStatusController,Serializable {

	@Override
	protected Class<OperationStatus> getEntityClass() {
		return OperationStatus.class;
	}

}