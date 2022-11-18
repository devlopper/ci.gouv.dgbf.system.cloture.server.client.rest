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
	
	/* Add Imputations */
	
	@Override
	public Response addImputation(String identifier, Collection<String> imputationsIdentifiers, Boolean existingIgnorable,String auditWho) {
		try {
			return Operation.getService().addImputation(identifier, (List<String>) imputationsIdentifiers, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addImputation(String identifier, Collection<String> imputationsIdentifiers, Boolean existingIgnorable) {
		return addImputation(identifier, imputationsIdentifiers, existingIgnorable, SessionHelper.getUserName());
	}
	
	@Override
	public Response addImputation(Operation operation, Collection<Imputation> imputations, Boolean existingIgnorable) {
		return addImputation(operation == null ? null : operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(imputations), existingIgnorable);
	}
	
	@Override
	public Response addImputationByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable, String auditWho) {
		try {
			return Operation.getService().addImputationByFilter(identifier, filter == null ? null : JsonbBuilder.create().toJson(filter),FilterFormat.JSON, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addImputationByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable) {
		return addImputationByFilter(identifier, filter, existingIgnorable,SessionHelper.getUserName());
	}
	
	@Override
	public Response addImputationByFilter(Operation operation, Filter.Dto filter, Boolean existingIgnorable) {
		return addImputationByFilter(operation == null ? null: operation.getIdentifier(), filter, existingIgnorable);
	}
	
	@Override
	public Response addImputationComprehensively(String identifier, Collection<String> imputationsIdentifiers, String auditWho) {
		try {
			return Operation.getService().addImputationComprehensively(identifier, (List<String>) imputationsIdentifiers, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response addImputationComprehensively(String identifier, Collection<String> imputationsIdentifiers) {
		return addImputationComprehensively(identifier, imputationsIdentifiers,SessionHelper.getUserName());
	}
	
	@Override
	public Response addImputationComprehensively(Operation operation, Collection<Imputation> imputations) {
		return addImputationComprehensively(operation == null ? null: operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(imputations));
	}
	
	/* Remove Imputations */
	
	@Override
	public Response removeImputation(String identifier, Collection<String> imputationsIdentifiers, Boolean existingIgnorable,String auditWho) {
		try {
			return Operation.getService().removeImputation(identifier, (List<String>) imputationsIdentifiers, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeImputation(String identifier, Collection<String> imputationsIdentifiers, Boolean existingIgnorable) {
		return removeImputation(identifier, imputationsIdentifiers, existingIgnorable, SessionHelper.getUserName());
	}
	
	@Override
	public Response removeImputation(Operation operation, Collection<Imputation> imputations, Boolean existingIgnorable) {
		return removeImputation(operation == null ? null : operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(imputations), existingIgnorable);
	}
	
	@Override
	public Response removeImputationByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable, String auditWho) {
		try {
			return Operation.getService().removeImputationByFilter(identifier, filter == null ? null : JsonbBuilder.create().toJson(filter),FilterFormat.JSON, existingIgnorable, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeImputationByFilter(String identifier, Filter.Dto filter, Boolean existingIgnorable) {
		return removeImputationByFilter(identifier, filter, existingIgnorable,SessionHelper.getUserName());
	}
	
	@Override
	public Response removeImputationByFilter(Operation operation, Filter.Dto filter, Boolean existingIgnorable) {
		return removeImputationByFilter(operation == null ? null: operation.getIdentifier(), filter, existingIgnorable);
	}
	
	@Override
	public Response removeImputationComprehensively(String identifier, Collection<String> imputationsIdentifiers, String auditWho) {
		try {
			return Operation.getService().removeImputationComprehensively(identifier, (List<String>) imputationsIdentifiers, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response removeImputationComprehensively(String identifier, Collection<String> imputationsIdentifiers) {
		return removeImputationComprehensively(identifier, imputationsIdentifiers,SessionHelper.getUserName());
	}
	
	@Override
	public Response removeImputationComprehensively(Operation operation, Collection<Imputation> imputations) {
		return removeImputationComprehensively(operation == null ? null: operation.getIdentifier(), FieldHelper.readSystemIdentifiersAsStrings(imputations));
	}
	
	
	/* Start Execution */
	
	@Override
	public Response startExecution(String identifier, String auditWho) {
		try {
			return Operation.getService().startExecution(identifier, auditWho);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response startExecution(Operation operation) {
		return startExecution(operation == null ? null : operation.getIdentifier(), SessionHelper.getUserName());
	}

	@Override
	protected Class<Operation> getEntityClass() {
		return Operation.class;
	}

}