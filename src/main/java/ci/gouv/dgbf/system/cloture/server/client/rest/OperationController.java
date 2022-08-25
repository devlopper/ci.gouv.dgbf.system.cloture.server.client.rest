package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.util.Collection;

import javax.ws.rs.core.Response;

import org.cyk.utility.persistence.query.Filter;
import org.cyk.utility.service.client.SpecificController;

public interface OperationController extends SpecificController<Operation> {

	Response create(String typeIdentifier,String code,String name,String reason,String auditWho);
	Response create(String typeIdentifier,String code,String name,String reason);
	Response create(OperationType type,String code,String name,String reason);
	Response create(Operation operation);
	
	/* Add */
	
	Response addAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response addAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable);
	Response addAct(Operation operation,Collection<Act> acts,Boolean existingIgnorable);
	
	Response addActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response addActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response addActByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response addActComprehensively(String identifier,Collection<String> actsIdentifiers,String auditWho);
	Response addActComprehensively(String identifier,Collection<String> actsIdentifiers);
	Response addActComprehensively(Operation operation,Collection<Act> acts);
	
	/* Remove */
	
	Response removeAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response removeAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable);
	Response removeAct(Operation operation,Collection<Act> acts,Boolean existingIgnorable);
	
	Response removeActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response removeActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response removeActByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response removeActComprehensively(String identifier,Collection<String> actsIdentifiers,String auditWho);
	Response removeActComprehensively(String identifier,Collection<String> actsIdentifiers);
	Response removeActComprehensively(Operation operation,Collection<Act> acts);
	
	/* Execute */
	
	void execute(Script operation,String trigger,Boolean blocking);
	void execute(Script operation,Boolean blocking);
}