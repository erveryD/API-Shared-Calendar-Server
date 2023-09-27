package domain.apiserver.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 여부 상수
 *
 * <pre>
 * {@link #Yes} 여
 * {@link #No} 부
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum YesOrNo {

  Yes("Y","여") {

    @Override
    public boolean toBoolean() { return true; }
  },
  No("N","부") {

    @Override
    public boolean toBoolean() { return false; }
  };

  private final String code;
  private final String title;

  public abstract boolean toBoolean();

}