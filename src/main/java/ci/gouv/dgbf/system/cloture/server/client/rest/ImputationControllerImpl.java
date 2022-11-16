package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ImputationControllerImpl extends SpecificController.AbstractImpl<Imputation> implements ImputationController,Serializable {

	@Override
	protected Class<Imputation> getEntityClass() {
		return Imputation.class;
	}

}