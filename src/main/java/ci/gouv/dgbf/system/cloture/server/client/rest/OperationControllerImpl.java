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
	public void create(String typeIdentifier, String code, String name, String reason, String auditWho) {
		try {
			Operation.getService().create(typeIdentifier, code, name, reason,auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public void create(String typeIdentifier, String code, String name, String reason) {
		create(typeIdentifier, code, name, reason, SessionHelper.getUserName());
	}
	
	@Override
	public void create(OperationType type, String code, String name, String reason) {
		create(type == null ? null : type.getIdentifier(), code, name, reason);
	}
	
	@Override
	public void create(Operation operation) {
		create(operation.getType(), operation.getCode(), operation.getName(), operation.getReason());
	}
	
	@Override
	public void execute(Script operation,String trigger,Boolean blocking) {
		try {
			Script.getService().execute(operation.getIdentifier(), trigger, blocking);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public void execute(Script operation, Boolean blocking) {
		execute(operation, SessionHelper.getUserName(), blocking);
	}

	@Override
	protected Class<Operation> getEntityClass() {
		return Operation.class;
	}

}