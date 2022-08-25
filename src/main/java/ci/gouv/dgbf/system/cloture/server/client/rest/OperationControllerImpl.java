package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.cyk.utility.__kernel__.field.FieldHelper;
import org.cyk.utility.__kernel__.session.SessionHelper;
import org.cyk.utility.persistence.query.Filter;
import org.cyk.utility.rest.ResponseHelper;
import org.cyk.utility.service.FilterFormat;
import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class OperationControllerImpl extends SpecificController.AbstractImpl<Operation> implements OperationController,Serializable {

	/* Create */
	
	@Override
	public Response create(String typeIdentifier, String code, String name, String reason, String auditWho) {
		try {
			return Operation.getService().create(typeIdentifier, code, name, reason,auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response create(String typeIdentifier, String code, String name, String reason) {
		return create(typeIdentifier, code, name, reason, SessionHelper.getUserName());
	}
	
	@Override
	public Response create(OperationType type, String code, String name, String reason) {
		return create(type == null ? null : type.getIdentifier(), code, name, reason);
	}
	
	@Override
	public Response create(Operation operation) {
		return create(operation.getType(), operation.getCode(), operation.getName(), operation.getReason());
	}
	
	/* Add acts */
	
	@Override
	public Response addAct(String identifier, Collection<String> actsIdentifiers, Boolean existingIgnorable,String auditWho) {
		try {
			return Operation.getService().addAct(identifier, (List<String>) actsIdentifiers, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addAct(String identifier, Collection<String> actsIdentifiers, Boolean existingIgnorable) {
		return addAct(identifier, actsIdentifiers, existingIgnorable, SessionHelper.getUserName());
	}
	
	@Override
	public Response addAct(Operation operation, Collection<Act> acts, Boolean existingIgnorable) {
		return addAct(operation == null ? null : operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(acts), existingIgnorable);
	}
	
	@Override
	public Response addActByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable, String auditWho) {
		try {
			return Operation.getService().addActByFilter(identifier, filter == null ? null : JsonbBuilder.create().toJson(filter),FilterFormat.JSON, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addActByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable) {
		return addActByFilter(identifier, filter, existingIgnorable,SessionHelper.getUserName());
	}
	
	@Override
	public Response addActByFilter(Operation operation, Filter.Dto filter, Boolean existingIgnorable) {
		return addActByFilter(operation == null ? null: operation.getIdentifier(), filter, existingIgnorable);
	}
	
	@Override
	public Response addActComprehensively(String identifier, Collection<String> actsIdentifiers, String auditWho) {
		try {
			return Operation.getService().addActComprehensively(identifier, (List<String>) actsIdentifiers, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addActComprehensively(String identifier, Collection<String> actsIdentifiers) {
		return addActComprehensively(identifier, actsIdentifiers,SessionHelper.getUserName());
	}
	
	@Override
	public Response addActComprehensively(Operation operation, Collection<Act> acts) {
		return addActComprehensively(operation == null ? null: operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(acts));
	}
	
	/* Remove acts */
	
	@Override
	public Response removeAct(String identifier, Collection<String> actsIdentifiers, Boolean existingIgnorable,String auditWho) {
		try {
			return Operation.getService().removeAct(identifier, (List<String>) actsIdentifiers, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeAct(String identifier, Collection<String> actsIdentifiers, Boolean existingIgnorable) {
		return removeAct(identifier, actsIdentifiers, existingIgnorable, SessionHelper.getUserName());
	}
	
	@Override
	public Response removeAct(Operation operation, Collection<Act> acts, Boolean existingIgnorable) {
		return removeAct(operation == null ? null : operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(acts), existingIgnorable);
	}
	
	@Override
	public Response removeActByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable, String auditWho) {
		try {
			return Operation.getService().removeActByFilter(identifier, filter == null ? null : JsonbBuilder.create().toJson(filter),FilterFormat.JSON, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeActByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable) {
		return removeActByFilter(identifier, filter, existingIgnorable,SessionHelper.getUserName());
	}
	
	@Override
	public Response removeActByFilter(Operation operation, Filter.Dto filter, Boolean existingIgnorable) {
		return removeActByFilter(operation == null ? null: operation.getIdentifier(), filter, existingIgnorable);
	}
	
	@Override
	public Response removeActComprehensively(String identifier, Collection<String> actsIdentifiers, String auditWho) {
		try {
			return Operation.getService().removeActComprehensively(identifier, (List<String>) actsIdentifiers, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeActComprehensively(String identifier, Collection<String> actsIdentifiers) {
		return removeActComprehensively(identifier, actsIdentifiers,SessionHelper.getUserName());
	}
	
	@Override
	public Response removeActComprehensively(Operation operation, Collection<Act> acts) {
		return removeActComprehensively(operation == null ? null: operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(acts));
	}
	
	/* Execute */
	
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