package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.service.ActDto;
import ci.gouv.dgbf.system.cloture.server.api.service.ActService;
import ci.gouv.dgbf.system.cloture.server.api.service.ImputationDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Imputation extends AbstractObject implements Serializable {

	@JsonbProperty(value = ImputationDto.JSON_IDENTIFIER) private String identifier;
	@JsonbProperty(value = ImputationDto.JSON_EXERCISE_AS_STRING) private String exerciseAsString;
	@JsonbProperty(value = ImputationDto.JSON_ACTIVITY_AS_STRING) private String activityAsString;	
	@JsonbProperty(value = ImputationDto.JSON_ECONOMIC_NATURE_AS_STRING) private String economicNatureAsString;

	@JsonbProperty(value = ActDto.JSON_LOCKED) private Boolean locked;
	@JsonbProperty(value = ActDto.JSON_LOCKED_AS_STRING) private String lockedAsString;
	@JsonbProperty(value = ActDto.JSON_LOCKED_REASONS) ArrayList<String> lockedReasons;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS) private Integer numberOfLocks;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS_ENABLED) private Integer numberOfLocksEnabled;
	
	@Override
	public String toString() {
		return activityAsString+"|"+economicNatureAsString;
	}

	public static ActService getService() {
		return (ActService) DependencyInjection.inject(SpecificServiceGetter.class).get(Imputation.class);
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_EXERCISE_AS_STRING = "exerciseAsString";
	public static final String FIELD_ACTIVITY_AS_STRING = "activityAsString";
	public static final String FIELD_ECONOMIC_NATURE_AS_STRING = "economicNatureAsString";
}