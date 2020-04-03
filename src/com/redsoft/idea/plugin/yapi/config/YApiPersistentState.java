package com.redsoft.idea.plugin.yapi.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.redsoft.idea.plugin.yapi.xml.YApiProjectProperty;
import com.redsoft.idea.plugin.yapi.xml.YApiPropertyConvertHolder;
import com.redsoft.idea.plugin.yapi.xml.YApiPropertyXmlConvert;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

@State(name = "ApplicationRedsoftYApiUpload")
public class YApiPersistentState implements PersistentStateComponent<Element> {

    private final YApiPropertyXmlConvert convert = YApiPropertyConvertHolder.getConvert();
    private YApiProjectProperty yApiProjectProperty;

    YApiPersistentState() {
    }

    public static YApiPersistentState getInstance() {
        return ServiceManager.getService(YApiPersistentState.class);
    }

    @Override
    public Element getState() {
        return yApiProjectProperty == null ? null : this.convert.serialize(yApiProjectProperty);
    }

    @Override
    public void loadState(@NotNull Element element) {
        this.yApiProjectProperty = this.convert.deserialize(element);
    }

}
