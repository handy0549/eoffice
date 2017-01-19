package com.arifin.Umum.dao;

import com.arifin.Umum.model.FileBucket;
import com.arifin.Umum.model.MultiFileBucket;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by ojiepermana on 1/19/2017.
 */
@Component
public class MultiFileValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return MultiFileBucket.class.isAssignableFrom(aClass);
    }
    @Override
    public void validate(Object o, Errors errors) {
        MultiFileBucket multiBucket = (MultiFileBucket) o;

        int index=0;

        for(FileBucket file : multiBucket.getFiles()){
            if(file.getFile()!=null){
                if (file.getFile().getSize() == 0) {
                    errors.rejectValue("files["+index+"].file", "missing.file");
                }
            }
            index++;
        }
    }
}
