package by.upmebel.upmecutfile.upmetask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatePattern {

    private String pattern;
    private final Map<String, Object> variables = new HashMap<>();

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setVariables(String name, Object value) {
        variables.put(name, value);
    }

    public Double evaluate(){
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(variables);
        context.addPropertyAccessor(new MapAccessor());
        Expression expression = parser.parseExpression(pattern);
        return expression.getValue(context, Double.class);
    }

}
