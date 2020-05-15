package com.redsoft.idea.plugin.yapiv2.component;

import com.intellij.notification.NotificationListener.UrlOpeningListener;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.redsoft.idea.plugin.yapiv2.config.YApiApplicationPersistentState;
import com.redsoft.idea.plugin.yapiv2.config.impl.ApplicationConfigReader;
import com.redsoft.idea.plugin.yapiv2.constant.NotificationConstants;
import com.redsoft.idea.plugin.yapiv2.constant.PluginConstants;
import com.redsoft.idea.plugin.yapiv2.constant.YApiConstants;
import com.redsoft.idea.plugin.yapiv2.xml.YApiApplicationProperty;
import com.redsoft.idea.plugin.yapiv2.xml.YApiPropertyConvertHolder;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

public class YApiInitComponent implements ProjectComponent {

    private final Project project;

    public YApiInitComponent(Project project) {
        this.project = project;
    }

    @Override
    public void projectOpened() {
        YApiApplicationProperty property = ApplicationConfigReader.read();
        if (property == null || !PluginConstants.currentVersion.equals(property.getVersion())) {
            String changeLogTitle = "<h4>版本1.3.7，添加Swagger参数解析支持，内置注释模板等</h4>";
            String changeLogContent = "<ol>"
                    + "        <li>添加Swagger参数解析支持</li>"
                    + "        <li>内置注释模板，无需再单独配置注释模板</li>"
                    + "        <li>优化1-兼容之前的配置方式</li>"
                    + "        <li>优化2-响应参数自动设置mock</li>"
                    + "      </ol>";
            NotificationConstants.NOTIFICATION_GROUP.createNotification(YApiConstants.name, "更新内容",
                    changeLogTitle + "\n" + changeLogContent
                            + "<p>更多信息请查看<a href=\"https://github.com/aqiu202/RedsoftYApiUpload/wiki/使用指南\">使用文档</a></p>",
                    NotificationType.INFORMATION, new UrlOpeningListener(false))
                    .notify(this.project);
            property = new YApiApplicationProperty();
            property.setVersion(PluginConstants.currentVersion);
            YApiApplicationPersistentState.getInstance().loadState(
                    YApiPropertyConvertHolder.getApplicationConvert().serialize(property));
        }
    }

    @Override
    public void projectClosed() {

    }

    @NotNull
    @Override
    public String getComponentName() {
        return "YApiInitComponent";
    }

    @Override
    public void initComponent() {

    }

    @Override
    public void disposeComponent() {

    }
}