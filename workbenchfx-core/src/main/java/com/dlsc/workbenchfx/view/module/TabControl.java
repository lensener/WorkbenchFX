package com.dlsc.workbenchfx.view.module;

import com.dlsc.workbenchfx.module.Module;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * Represents the standard control used to display {@link Module}s as tabs in the toolbar.
 *
 * @author François Martin
 * @author Marco Sanfratello
 */
public class TabControl extends HBox {
  private final Button closeBtn;
  private final Module module;
  private final Node icon;
  private final Label nameLbl;
  private final FontAwesomeIconView closeIconView;

  /**
   * Constructs a new {@link TabControl}.
   *
   * @param module which is used to create the {@link TabControl}
   */
  public TabControl(Module module) {
    this.module = module;

    this.icon = module.getIcon();
    this.nameLbl = new Label(module.getName());

    closeIconView = new FontAwesomeIconView(FontAwesomeIcon.CLOSE);
    this.closeBtn = new Button("", closeIconView);

    layoutParts();
  }

  private void layoutParts() {
    getChildren().addAll(
        icon,
        nameLbl,
        closeBtn
    );

    icon.getStyleClass().add("tabIcon");
    nameLbl.getStyleClass().add("tabNameLbl");

    closeBtn.getStyleClass().add("closeBtn");
    closeIconView.setStyleClass("closeIconView");

    getStyleClass().add("tabControl");
  }

  /**
   * Defines the {@link EventHandler} which should be called when the close button on this tab is
   * being pressed.
   *
   * @param event to be called
   */
  public void setOnClose(EventHandler<ActionEvent> event) {
    closeBtn.setOnAction(event);
  }

  /**
   * Defines the {@link EventHandler} which should be called when this control is being clicked on,
   * setting the tab active.
   *
   * @param event to be called
   */
  public void setOnActive(EventHandler<MouseEvent> event) {
    setOnMouseClicked(event);
  }

}