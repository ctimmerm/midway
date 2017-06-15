package com.relex.midway.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by omerfurkantercan on 15/06/2017.
 */
public class NextTurnRequest {
    private Report report;

    public NextTurnRequest(){}

    @JsonProperty
    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NextTurnRequest{");
        sb.append("report=").append(report);
        sb.append('}');
        return sb.toString();
    }
}
