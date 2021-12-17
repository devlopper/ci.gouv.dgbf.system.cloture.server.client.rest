package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.persistence.query.Filter;
import org.cyk.utility.service.client.SpecificController;

public interface ActController extends SpecificController<Act> {

	void lock(List<Act> acts,String trigger);
	void lock(List<Act> acts);
	void lock(Act...acts);
	void lock(Filter.Dto filter);
	
	void unlockByIdentifiers(Collection<String> actsIdentifiers,String trigger);
	void unlockByIdentifiers(Collection<String> actsIdentifiers);
	
	void unlock(List<Act> acts,String trigger);
	void unlock(List<Act> acts);
	void unlock(Act...acts);
	void unlock(Filter.Dto filter);
}