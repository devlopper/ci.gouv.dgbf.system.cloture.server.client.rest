package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.util.List;

import org.cyk.utility.service.client.SpecificController;

public interface ActController extends SpecificController<Act> {

	//void lock(List<String> identifiers,String trigger);
	//void lock(List<String> identifiers);
	
	void lock(List<Act> acts,String trigger);
	void lock(List<Act> acts);
	
	//void unlock(List<String> identifiers,String trigger);
	//void unlock(List<String> identifiers);
	
	void unlock(List<Act> acts,String trigger);
	void unlock(List<Act> acts);
	
}