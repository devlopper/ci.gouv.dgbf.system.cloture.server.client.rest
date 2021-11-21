package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;

import org.cyk.utility.__kernel__.session.SessionHelper;
import org.cyk.utility.rest.ResponseHelper;
import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class OperationControllerImpl extends SpecificController.AbstractImpl<Operation> implements OperationController,Serializable {

	@Override
	public void execute(Operation operation,String trigger,Boolean blocking) {
		try {
			Operation.getService().execute(operation.getIdentifier(), trigger, blocking);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public void execute(Operation operation, Boolean blocking) {
		execute(operation, SessionHelper.getUserName(), blocking);
	}

	@Override
	protected Class<Operation> getEntityClass() {
		return Operation.class;
	}

}