package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class OperationControllerImplOLD extends SpecificController.AbstractImpl<Operation> implements OperationControllerOLD,Serializable {

	@Override
	protected Class<Operation> getEntityClass() {
		return Operation.class;
	}

}