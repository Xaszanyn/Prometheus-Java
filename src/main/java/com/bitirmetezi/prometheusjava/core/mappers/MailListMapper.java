package com.bitirmetezi.prometheusjava.core.mappers;

import com.bitirmetezi.prometheusjava.controller.maillistcontroller.MailListCreateRequest;
import com.bitirmetezi.prometheusjava.controller.maillistcontroller.MailListUpdateRequest;
import com.bitirmetezi.prometheusjava.data.entity.MailList;
import com.bitirmetezi.prometheusjava.service.maillistservice.MailListCreateServiceInput;
import com.bitirmetezi.prometheusjava.service.maillistservice.MailListServiceOutput;
import com.bitirmetezi.prometheusjava.service.maillistservice.MailListUpdateServiceInput;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MailListMapper {

    public static List<MailListServiceOutput> map(List<MailList> mailLists){
        List<MailListServiceOutput> outputList = new ArrayList<>();
        for(MailList mailList : mailLists){
            MailListServiceOutput serviceOutput = MailListServiceOutput.builder()
                    .id(mailList.getId())
                    .name(mailList.getName())
                    .insertTime(DateTimeMapper.map(mailList.getInsertTime()))
                    .updateTime(DateTimeMapper.map(mailList.getUpdateTime()))
                    .insertUserId(mailList.getInsertUserId())
                    .lastUpdateUserId(mailList.getLastUpdateUserId())
                    .build();
            outputList.add(serviceOutput);
        }
        return outputList;
    }

    public static MailListServiceOutput map(Optional<MailList> optionalMailList){
        if (optionalMailList.isPresent()){
            MailList mailList = optionalMailList.get();
            return MailListServiceOutput.builder()
                    .id(mailList.getId())
                    .name(mailList.getName())
                    .insertTime(DateTimeMapper.map(mailList.getInsertTime()))
                    .updateTime(DateTimeMapper.map(mailList.getUpdateTime()))
                    .insertUserId(mailList.getInsertUserId())
                    .lastUpdateUserId(mailList.getLastUpdateUserId())
                    .build();
        }
        return null;
    }

    public static MailList map(MailListCreateServiceInput serviceInput){
        return MailList.builder()
                .name(serviceInput.getName())
                .insertTime(serviceInput.getInsertTime())
                .updateTime(serviceInput.getUpdateTime())
                .insertUserId(serviceInput.getInsertUserId())
                .lastUpdateUserId(serviceInput.getLastUpdateUserId())
                .build();
    }

    public static MailList map(MailListUpdateServiceInput serviceInput){
        return MailList.builder()
                .id(serviceInput.getId())
                .name(serviceInput.getName())
                .insertTime(serviceInput.getUpdateTime())
                .updateTime(serviceInput.getUpdateTime())
                .insertUserId(serviceInput.getLastUpdateUserId())
                .lastUpdateUserId(serviceInput.getLastUpdateUserId())
                .build();
    }

    public static MailListCreateServiceInput map(MailListCreateRequest request){
        return MailListCreateServiceInput.builder()
                .name(request.getName())
                .insertTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .updateTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .insertUserId(request.getInsertUserId())
                .lastUpdateUserId(request.getLastUpdateUserId())
                .build();
    }

    public static MailListUpdateServiceInput map(MailListUpdateRequest request){
        return MailListUpdateServiceInput.builder()
                .id(request.getId())
                .name(request.getName())
                .updateTime(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(3)))
                .lastUpdateUserId(request.getLastUpdateUserId())
                .build();
    }
}
