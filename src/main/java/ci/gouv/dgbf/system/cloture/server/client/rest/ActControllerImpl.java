package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.session.SessionHelper;
import org.cyk.utility.persistence.query.Filter;
import org.cyk.utility.rest.ResponseHelper;
import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ActControllerImpl extends SpecificController.AbstractImpl<Act> implements ActController,Serializable {

	@Override
	protected Class<Act> getEntityClass() {
		return Act.class;
	}

	@Override
	public void lock(List<Act> acts, String trigger) {
		try {
			Act.getService().lock(acts == null ? null : acts.stream().map(Act::getIdentifier).collect(Collectors.toList()), trigger);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}

	@Override
	public void lock(List<Act> acts) {
		lock(acts, SessionHelper.getUserName());
	}
	
	@Override
	public void lock(Act... acts) {
		lock(CollectionHelper.listOf(Boolean.TRUE, acts));
	}
	
	@Override
	public void lock(Filter.Dto filter) {
		throw new RuntimeException("Pas encore implémenté");
	}
	
	@Override
	public Response unlockByIdentifiers(Collection<String> actsIdentifiers, String trigger,Boolean processedIgnorable) {
		try {
			return Act.getService().unlock(new ArrayList<String>(actsIdentifiers), trigger,processedIgnorable);
		} catch (WebApplicationException exception) {
			throw new RuntimeException(ResponseHelper.getEntity(String.class, exception.getResponse()));
		}
	}
	
	@Override
	public Response unlockByIdentifiers(Collection<String> actsIdentifiers,Boolean processedIgnorable) {
		return unlockByIdentifiers(actsIdentifiers, SessionHelper.getUserName(),processedIgnorable);
	}

	@Override
	public Response unlock(List<Act> acts, String trigger,Boolean processedIgnorable) {
		return unlockByIdentifiers(acts == null ? null : acts.stream().map(Act::getIdentifier).collect(Collectors.toList()), trigger,processedIgnorable);
	}

	@Override
	public Response unlock(List<Act> acts,Boolean processedIgnorable) {
		return unlock(acts, SessionHelper.getUserName(),processedIgnorable);
	}

	@Override
	public Response unlock(Boolean processedIgnorable,Act... acts) {
		return unlock(CollectionHelper.listOf(Boolean.TRUE, acts),processedIgnorable);
	}
	
	@Override
	public Response unlock(Filter.Dto filter,Boolean processedIgnorable) {
		throw new RuntimeException("Pas encore implémenté");
	}
}