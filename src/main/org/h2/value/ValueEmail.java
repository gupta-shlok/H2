package org.h2.value;

import org.h2.api.ErrorCode;
import org.h2.message.DbException;

import java.util.regex.Pattern;

public class ValueEmail extends ValueStringBase{

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    ValueEmail(String v) {
        super(v);
        if (!checkCorrectEmailRegex(v)) {
            throw DbException.get(ErrorCode.INVALID_EMAIL, v);
        }
    }

    private boolean checkCorrectEmailRegex(String email) {
        return pattern.matcher(email).matches();
    }
    @Override
    public String getTraceSQL() {
        return super.getTraceSQL();
    }

    @Override
    public String getSQL(int sqlFlags) {
        return super.getSQL(sqlFlags);
    }

    @Override
    public StringBuilder getSQL(StringBuilder builder, int sqlFlags) {
        return builder.append("EMAIL: ").append(value);
    }

    @Override
    public int getValueType() {
        return EMAIL;
    }

    public static ValueEmail get(String s) {
        return new ValueEmail(s);
    }
}
