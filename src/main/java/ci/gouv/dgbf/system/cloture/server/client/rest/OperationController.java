package ci.gouv.dgbf.system.cloture.server.client.rest;

import org.cyk.utility.service.client.SpecificController;

public interface OperationController extends SpecificController<Operation> {

	void execute(Operation operation,String trigger,Boolean blocking);
	void execute(Operation operation,Boolean blocking);
}