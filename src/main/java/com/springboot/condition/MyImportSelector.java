package com.springboot.condition;

import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @author yc
 * @create 2020-04-27-19:11
 */
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector  {
    // 返回值，就是导入到容器中的组件全类名
    // AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        for (String a : annotationTypes)
        {
            System.out.println(a);
        }
        return new String[]{"com.springboot.bean.Blue","com.springboot.bean.Red"};
        //这里不能返回null，下面用到了数组长度，会越界
        //return new String[0];
    }
}
