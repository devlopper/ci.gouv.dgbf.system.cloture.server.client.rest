package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.Response;

import org.cyk.utility.persistence.query.Filter;
import org.cyk.utility.service.client.SpecificController;

public interface ActController extends SpecificController<Act> {

	void lock(List<Act> acts,String trigger);
	void lock(List<Act> acts);
	void lock(Act...acts);
	void lock(Filter.Dto filter);
	
	Response unlockByIdentifiers(Collection<String> actsIdentifiers,String trigger,Boolean processedIgnorable);
	Response unlockByIdentifiers(Collection<String> actsIdentifiers,Boolean processedIgnorable);
	
	Response unlock(List<Act> acts,String trigger,Boolean processedIgnorable);
	Response unlock(List<Act> acts,Boolean processedIgnorable);
	Response unlock(Boolean processedIgnorable,Act...acts);
	Response unlock(Filter.Dto filter,Boolean processedIgnorable);
}