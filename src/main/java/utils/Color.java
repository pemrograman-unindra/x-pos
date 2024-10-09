package utils;

public enum Color {
	RESET(0),
	BOLD(1),
	FAINT(2),
	ITALIC(3),
	UNDERLINE(4),
	BLINK_SLOW(5),
	BLINK_RAPID(6),
	REVERSE_VIDEO(7),
	CONCEALED(8),
	CROSSED_OUT(9),
	BLACK(30),
	RED(31),
	GREEN(32),
	YELLOW(33),
	BLUE(34),
	MAGENTA(35),
	CYAN(36),
	WHITE(37),
	HI_BLACK(90),
	HI_RED(91),
	HI_GREEN(92),
	HI_YELLOW(93),
	HI_BLUE(94),
	HI_MAGENTA(95),
	HI_CYAN(96),
	HI_WHITE(97),
	BG_BLACK(40),
	BG_RED(41),
	BG_GREEN(42),
	BG_YELLOW(43),
	BG_BLUE(44),
	BG_MAGENTA(45),
	BG_CYAN(46),
	BG_WHITE(47),
	BG_HI_BLACK(100),
	BG_HI_RED(101),
	BG_HI_GREEN(102),
	BG_HI_YELLOW(103),
	BG_HI_BLUE(104),
	BG_HI_MAGENTA(105),
	BG_HI_CYAN(106),
	BG_HI_WHITE(107);

	private final int value;

	Color(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
