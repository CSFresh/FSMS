package com.amanda.fsms.data;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;

@Getter
@Setter
public class ScoreData {
    private Integer CP;
    private Integer CPNo;
    private String action;
    private List<FollowerAndComment> followerAndComments;
}
