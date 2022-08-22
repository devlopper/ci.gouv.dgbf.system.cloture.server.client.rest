package ci.gouv.dgbf.system.cloture.server.client.rest;

import org.cyk.utility.service.client.SpecificController;

public interface OperationController extends SpecificController<Operation> {

	void create(String typeIdentifier,String code,String name,String reason,String auditWho);
	void create(String typeIdentifier,String code,String name,String reason);
	void create(OperationType type,String code,String name,String reason);
	
	void execute(Script operation,String trigger,Boolean blocking);
	void execute(Script operation,Boolean blocking);
}