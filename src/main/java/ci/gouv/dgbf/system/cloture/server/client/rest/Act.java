package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;
import java.util.ArrayList;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.service.client.SpecificServiceGetter;

import ci.gouv.dgbf.system.cloture.server.api.persistence.ActOperationType;
import ci.gouv.dgbf.system.cloture.server.api.persistence.ActTypeEnum;
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
	@JsonbProperty(value = ActDto.JSON_TYPE) private ActTypeEnum type;
	@JsonbProperty(value = ActDto.JSON_TYPE_AS_STRING) private String typeAsString;
	@JsonbProperty(value = ActDto.JSON_OPERATION_TYPE) private ActOperationType operationType;
	@JsonbProperty(value = ActDto.JSON_TRIGGER) private String trigger;
	@JsonbProperty(value = ActDto.JSON_OPERATION_DATE_STRING) private String operationDateString;
	@JsonbProperty(value = ActDto.JSON_STATUS_STRING) private String statusString;
	@JsonbProperty(value = ActDto.JSON_LATEST_OPERATION_STRING) private String latestOperationString;
	
	@JsonbProperty(value = ActDto.JSON_LOCKED) private Boolean locked;
	@JsonbProperty(value = ActDto.JSON_LOCKED_REASONS) ArrayList<String> lockedReasons;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS) private Integer numberOfLocks;
	@JsonbProperty(value = ActDto.JSON_NUMBER_OF_LOCKS_ENABLED) private Integer numberOfLocksEnabled;
	
	@Override
	public String toString() {
		return code+" "+name;
	}

	public static ActService getService() {
		return (ActService) DependencyInjection.inject(SpecificServiceGetter.class).get(Act.class);
	}
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_CODE = "code";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_TYPE = "type";
	public static final String FIELD_TYPE_AS_STRING = "typeAsString";
	public static final String FIELD_OPERATION_TYPE = "operationType";
	public static final String FIELD_TRIGGER = "trigger";
	public static final String FIELD_OPERATION_DATE_STRING = "operationDateString";
	public static final String FIELD_NUMBER_OF_LOCKS_ENABLED = "numberOfLocksEnabled";
	public static final String FIELD_LOCKED_REASONS = "lockedReasons";
	public static final String FIELD_STATUS_STRING = "statusString";
	public static final String FIELD_LATEST_OPERATION_STRING = "latestOperationString";
}