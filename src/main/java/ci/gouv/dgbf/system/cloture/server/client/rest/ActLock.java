package ci.gouv.dgbf.system.cloture.server.client.rest;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

import org.cyk.utility.__kernel__.object.AbstractObject;

import ci.gouv.dgbf.system.cloture.server.api.service.ActLockDto;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class ActLock extends AbstractObject implements Serializable{

	@JsonbProperty(value = ActLockDto.JSON_IDENTIFIER) private String identifier;
	@JsonbProperty(value = ActLockDto.JSON_REASON) private String reason;
	@JsonbProperty(value = ActLockDto.JSON_ENABLED) private Boolean enabled;	
	@JsonbProperty(value = ActLockDto.JSON_ENABLED_STRING) String enabledString;
	@JsonbProperty(value = ActLockDto.JSON_BEGIN_DATE) String beginDate;
	@JsonbProperty(value = ActLockDto.JSON_END_DATE) String endDate;
	@JsonbProperty(value = ActLockDto.JSON_LATEST_OPERATION) String latestOperation;
	
	public static final String FIELD_IDENTIFIER = "identifier";
	public static final String FIELD_REASON = "reason";
	public static final String FIELD_ENABLED = "enabled";
	public static final String FIELD_ENABLED_STRING = "enabledString";
	public static final String FIELD_BEGIN_DATE = "beginDate";
	public static final String FIELD_BEGIN_DATE_STRING = "beginDateString";
	public static final String FIELD_END_DATE = "endDate";
	public static final String FIELD_END_DATE_STRING = "endDateString";
	public static final String FIELD_LATEST_OPERATION = "latestOperation";
}