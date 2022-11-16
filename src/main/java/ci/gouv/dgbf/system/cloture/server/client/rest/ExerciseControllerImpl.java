package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.service.client.SpecificController;

@ApplicationScoped
public class ExerciseControllerImpl extends SpecificController.AbstractImpl<Exercise> implements ExerciseController,Serializable {

	@Override
	protected Class<Exercise> getEntityClass() {
		return Exercise.class;
	}

}