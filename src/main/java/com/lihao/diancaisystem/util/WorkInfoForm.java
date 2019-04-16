package com.lihao.diancaisystem.util;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class WorkInfoForm {

    public  interface  Update{};

    public  interface  Add{};

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private  Long id;
}
