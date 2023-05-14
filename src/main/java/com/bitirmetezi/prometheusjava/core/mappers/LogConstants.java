package com.bitirmetezi.prometheusjava.core.mappers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogConstants {
    ALERT_REPOSITORY_ACCESS_ERROR("An error occured while trying to access PrometheusAlertRepository"),
    HISTORY_REPOSITORY_ACCESS_ERROR("An error occured while trying to access AlertHistoryRepository"),
    MAIL_LIST_REPOSITORY_ACCESS_ERROR("An error occured while trying to access MailListRepository"),
    USER_REPOSITORY_ACCESS_ERROR("An error occured while trying to access UserRepository");

    private final String name;
}
