package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.persistence.ActOperationType;
import ci.gouv.dgbf.system.cloture.server.api.service.ActDto;
import ci.gouv.dgbf.system.cloture.server.api.service.ActService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class Act extends AbstractObject implements Serializable {

	@JsonbProperty(value = ActDto.JSON_IDENTIFIER) private String identifier;
	@JsonbProperty(value = ActDto.JSON_CODE) private String code;	
	@JsonbProperty(value = ActDto.JSON_NAME) private String name;
	@JsonbProperty(value = ActDto.JSON_OPERATION_TYPE) ActOperationType operationType;
	@JsonbProperty(value = ActDto.JSON_TRIGGER) String trigger;
	@JsonbProperty(value = ActDto.JSON_OPERATION_DATE_STRING) String operationDateString;
	
	@JsonbProperty(value = ActDto.JSON_LOCKED) private Boolean locked;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS) private Integer numberOfLocks;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS_ENABLED) private Integer numberOfLocksEnabled;
	
	@Override
	public String toString() {
		return name;
	}

	public static ActService getService() {
		return (ActService) DependencyInjection.inject(SpecificServiceGetter.class).get(Act.class);
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_OPERATION_TYPE = "operationType";
	public static final String FIELD_TRIGGER = "trigger";
	public static final String FIELD_OPERATION_DATE_STRING = "operationDateString";
	public static final String FIELD_NUMBER_OF_LOCKS_ENABLED = "numberOfLocksEnabled";
}