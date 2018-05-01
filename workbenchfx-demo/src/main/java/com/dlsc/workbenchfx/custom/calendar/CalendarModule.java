package com.dlsc.workbenchfx.custom.calendar;

import com.dlsc.workbenchfx.module.AbstractModule;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.Node;

import java.util.Objects;

public class CalendarModule extends AbstractModule {

  private CalendarView calendarView;

  public CalendarModule() {
    super("Calendar", FontAwesomeIcon.CALENDAR);
  }

  @Override
  public Node activate() {
    if (Objects.isNull(calendarView)) {
      calendarView = new CalendarView();
    }
    calendarView.startClock();
    return calendarView;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void deactivate() {
    calendarView.stopClock();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean destroy() {
    calendarView.stopClock();
    calendarView = null;
    return true;
  }
}