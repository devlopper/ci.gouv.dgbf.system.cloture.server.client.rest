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
	
	/* Add Act */
	
	Response addAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response addAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable);
	Response addAct(Operation operation,Collection<Act> acts,Boolean existingIgnorable);
	
	Response addActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response addActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response addActByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response addActComprehensively(String identifier,Collection<String> actsIdentifiers,String auditWho);
	Response addActComprehensively(String identifier,Collection<String> actsIdentifiers);
	Response addActComprehensively(Operation operation,Collection<Act> acts);
	
	/* Remove Act */
	
	Response removeAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response removeAct(String identifier,Collection<String> actsIdentifiers,Boolean existingIgnorable);
	Response removeAct(Operation operation,Collection<Act> acts,Boolean existingIgnorable);
	
	Response removeActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response removeActByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response removeActByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response removeActComprehensively(String identifier,Collection<String> actsIdentifiers,String auditWho);
	Response removeActComprehensively(String identifier,Collection<String> actsIdentifiers);
	Response removeActComprehensively(Operation operation,Collection<Act> acts);
	
	/* Add Imputation */
	
	Response addImputation(String identifier,Collection<String> imputationsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response addImputation(String identifier,Collection<String> imputationsIdentifiers,Boolean existingIgnorable);
	Response addImputation(Operation operation,Collection<Imputation> imputations,Boolean existingIgnorable);
	
	Response addImputationByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response addImputationByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response addImputationByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response addImputationComprehensively(String identifier,Collection<String> imputationsIdentifiers,String auditWho);
	Response addImputationComprehensively(String identifier,Collection<String> imputationsIdentifiers);
	Response addImputationComprehensively(Operation operation,Collection<Imputation> imputations);
	
	/* Remove Imputation */
	
	Response removeImputation(String identifier,Collection<String> imputationsIdentifiers,Boolean existingIgnorable,String auditWho);
	Response removeImputation(String identifier,Collection<String> imputationsIdentifiers,Boolean existingIgnorable);
	Response removeImputation(Operation operation,Collection<Imputation> imputations,Boolean existingIgnorable);
	
	Response removeImputationByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable,String auditWho);
	Response removeImputationByFilter(String identifier,Filter.Dto filter,Boolean existingIgnorable);
	Response removeImputationByFilter(Operation operation,Filter.Dto filter,Boolean existingIgnorable);
	
	Response removeImputationComprehensively(String identifier,Collection<String> imputationsIdentifiers,String auditWho);
	Response removeImputationComprehensively(String identifier,Collection<String> imputationsIdentifiers);
	Response removeImputationComprehensively(Operation operation,Collection<Imputation> imputations);
	
	/* Execute */
	
	Response startExecution(String identifier,String auditWho);
	Response startExecution(Operation operation);
}