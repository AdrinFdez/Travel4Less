
package aiss.model.Covid19data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastChecked",
    "covid19Stats"
})
public class Data {

    @JsonProperty("lastChecked")
    private String lastChecked;
    @JsonProperty("covid19Stats")
    private List<Covid19Stat> covid19Stats = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lastChecked")
    public String getLastChecked() {
        return lastChecked;
    }

    @JsonProperty("lastChecked")
    public void setLastChecked(String lastChecked) {
        this.lastChecked = lastChecked;
    }

    @JsonProperty("covid19Stats")
    public List<Covid19Stat> getCovid19Stats() {
        return covid19Stats;
    }

    @JsonProperty("covid19Stats")
    public void setCovid19Stats(List<Covid19Stat> covid19Stats) {
        this.covid19Stats = covid19Stats;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
