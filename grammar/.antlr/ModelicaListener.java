// Generated from /home/jgoppert/git/gomoca/grammar/Modelica.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ModelicaParser}.
 */
public interface ModelicaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#stored_definition}.
	 * @param ctx the parse tree
	 */
	void enterStored_definition(ModelicaParser.Stored_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#stored_definition}.
	 * @param ctx the parse tree
	 */
	void exitStored_definition(ModelicaParser.Stored_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#class_definition}.
	 * @param ctx the parse tree
	 */
	void enterClass_definition(ModelicaParser.Class_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#class_definition}.
	 * @param ctx the parse tree
	 */
	void exitClass_definition(ModelicaParser.Class_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#class_prefixes}.
	 * @param ctx the parse tree
	 */
	void enterClass_prefixes(ModelicaParser.Class_prefixesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#class_prefixes}.
	 * @param ctx the parse tree
	 */
	void exitClass_prefixes(ModelicaParser.Class_prefixesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code class_type_block}
	 * labeled alternative in {@link ModelicaParser#class_type}.
	 * @param ctx the parse tree
	 */
	void enterClass_type_block(ModelicaParser.Class_type_blockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code class_type_block}
	 * labeled alternative in {@link ModelicaParser#class_type}.
	 * @param ctx the parse tree
	 */
	void exitClass_type_block(ModelicaParser.Class_type_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#class_specifier}.
	 * @param ctx the parse tree
	 */
	void enterClass_specifier(ModelicaParser.Class_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#class_specifier}.
	 * @param ctx the parse tree
	 */
	void exitClass_specifier(ModelicaParser.Class_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#long_class_specifier}.
	 * @param ctx the parse tree
	 */
	void enterLong_class_specifier(ModelicaParser.Long_class_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#long_class_specifier}.
	 * @param ctx the parse tree
	 */
	void exitLong_class_specifier(ModelicaParser.Long_class_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#composition}.
	 * @param ctx the parse tree
	 */
	void enterComposition(ModelicaParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#composition}.
	 * @param ctx the parse tree
	 */
	void exitComposition(ModelicaParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#language_specification}.
	 * @param ctx the parse tree
	 */
	void enterLanguage_specification(ModelicaParser.Language_specificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#language_specification}.
	 * @param ctx the parse tree
	 */
	void exitLanguage_specification(ModelicaParser.Language_specificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#external_function_call}.
	 * @param ctx the parse tree
	 */
	void enterExternal_function_call(ModelicaParser.External_function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#external_function_call}.
	 * @param ctx the parse tree
	 */
	void exitExternal_function_call(ModelicaParser.External_function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#element_list}.
	 * @param ctx the parse tree
	 */
	void enterElement_list(ModelicaParser.Element_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#element_list}.
	 * @param ctx the parse tree
	 */
	void exitElement_list(ModelicaParser.Element_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code element_class_definition}
	 * labeled alternative in {@link ModelicaParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement_class_definition(ModelicaParser.Element_class_definitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code element_class_definition}
	 * labeled alternative in {@link ModelicaParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement_class_definition(ModelicaParser.Element_class_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code element_component_clause}
	 * labeled alternative in {@link ModelicaParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement_component_clause(ModelicaParser.Element_component_clauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code element_component_clause}
	 * labeled alternative in {@link ModelicaParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement_component_clause(ModelicaParser.Element_component_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#element_options}.
	 * @param ctx the parse tree
	 */
	void enterElement_options(ModelicaParser.Element_optionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#element_options}.
	 * @param ctx the parse tree
	 */
	void exitElement_options(ModelicaParser.Element_optionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#import_clause}.
	 * @param ctx the parse tree
	 */
	void enterImport_clause(ModelicaParser.Import_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#import_clause}.
	 * @param ctx the parse tree
	 */
	void exitImport_clause(ModelicaParser.Import_clauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code import_clause_simple}
	 * labeled alternative in {@link ModelicaParser#import_clause_types}.
	 * @param ctx the parse tree
	 */
	void enterImport_clause_simple(ModelicaParser.Import_clause_simpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code import_clause_simple}
	 * labeled alternative in {@link ModelicaParser#import_clause_types}.
	 * @param ctx the parse tree
	 */
	void exitImport_clause_simple(ModelicaParser.Import_clause_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#import_list}.
	 * @param ctx the parse tree
	 */
	void enterImport_list(ModelicaParser.Import_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#import_list}.
	 * @param ctx the parse tree
	 */
	void exitImport_list(ModelicaParser.Import_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#component_clause}.
	 * @param ctx the parse tree
	 */
	void enterComponent_clause(ModelicaParser.Component_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#component_clause}.
	 * @param ctx the parse tree
	 */
	void exitComponent_clause(ModelicaParser.Component_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#type_prefix}.
	 * @param ctx the parse tree
	 */
	void enterType_prefix(ModelicaParser.Type_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#type_prefix}.
	 * @param ctx the parse tree
	 */
	void exitType_prefix(ModelicaParser.Type_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#component_list}.
	 * @param ctx the parse tree
	 */
	void enterComponent_list(ModelicaParser.Component_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#component_list}.
	 * @param ctx the parse tree
	 */
	void exitComponent_list(ModelicaParser.Component_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#component_declaration}.
	 * @param ctx the parse tree
	 */
	void enterComponent_declaration(ModelicaParser.Component_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#component_declaration}.
	 * @param ctx the parse tree
	 */
	void exitComponent_declaration(ModelicaParser.Component_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ModelicaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ModelicaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#equation_section}.
	 * @param ctx the parse tree
	 */
	void enterEquation_section(ModelicaParser.Equation_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#equation_section}.
	 * @param ctx the parse tree
	 */
	void exitEquation_section(ModelicaParser.Equation_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#algorithm_section}.
	 * @param ctx the parse tree
	 */
	void enterAlgorithm_section(ModelicaParser.Algorithm_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#algorithm_section}.
	 * @param ctx the parse tree
	 */
	void exitAlgorithm_section(ModelicaParser.Algorithm_sectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equation_simple}
	 * labeled alternative in {@link ModelicaParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation_simple(ModelicaParser.Equation_simpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equation_simple}
	 * labeled alternative in {@link ModelicaParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation_simple(ModelicaParser.Equation_simpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_component_reference}
	 * labeled alternative in {@link ModelicaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_component_reference(ModelicaParser.Statement_component_referenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_component_reference}
	 * labeled alternative in {@link ModelicaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_component_reference(ModelicaParser.Statement_component_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#if_equation}.
	 * @param ctx the parse tree
	 */
	void enterIf_equation(ModelicaParser.If_equationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#if_equation}.
	 * @param ctx the parse tree
	 */
	void exitIf_equation(ModelicaParser.If_equationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#for_indices}.
	 * @param ctx the parse tree
	 */
	void enterFor_indices(ModelicaParser.For_indicesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#for_indices}.
	 * @param ctx the parse tree
	 */
	void exitFor_indices(ModelicaParser.For_indicesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#for_index}.
	 * @param ctx the parse tree
	 */
	void enterFor_index(ModelicaParser.For_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#for_index}.
	 * @param ctx the parse tree
	 */
	void exitFor_index(ModelicaParser.For_indexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression_simple}
	 * labeled alternative in {@link ModelicaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression_simple(ModelicaParser.Expression_simpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expression_simple}
	 * labeled alternative in {@link ModelicaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression_simple(ModelicaParser.Expression_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expression(ModelicaParser.Simple_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#simple_expression}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expression(ModelicaParser.Simple_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expression(ModelicaParser.Logical_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#logical_expression}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expression(ModelicaParser.Logical_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#logical_term}.
	 * @param ctx the parse tree
	 */
	void enterLogical_term(ModelicaParser.Logical_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#logical_term}.
	 * @param ctx the parse tree
	 */
	void exitLogical_term(ModelicaParser.Logical_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(ModelicaParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(ModelicaParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic_expression(ModelicaParser.Arithmetic_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#arithmetic_expression}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic_expression(ModelicaParser.Arithmetic_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ModelicaParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ModelicaParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(ModelicaParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(ModelicaParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_unsigned_number}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_unsigned_number(ModelicaParser.Primary_unsigned_numberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_unsigned_number}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_unsigned_number(ModelicaParser.Primary_unsigned_numberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_string}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_string(ModelicaParser.Primary_stringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_string}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_string(ModelicaParser.Primary_stringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_true}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_true(ModelicaParser.Primary_trueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_true}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_true(ModelicaParser.Primary_trueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_false}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_false(ModelicaParser.Primary_falseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_false}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_false(ModelicaParser.Primary_falseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_derivative}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_derivative(ModelicaParser.Primary_derivativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_derivative}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_derivative(ModelicaParser.Primary_derivativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primary_component_reference}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_component_reference(ModelicaParser.Primary_component_referenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primary_component_reference}
	 * labeled alternative in {@link ModelicaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_component_reference(ModelicaParser.Primary_component_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(ModelicaParser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(ModelicaParser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(ModelicaParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(ModelicaParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#component_reference}.
	 * @param ctx the parse tree
	 */
	void enterComponent_reference(ModelicaParser.Component_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#component_reference}.
	 * @param ctx the parse tree
	 */
	void exitComponent_reference(ModelicaParser.Component_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#component_scope}.
	 * @param ctx the parse tree
	 */
	void enterComponent_scope(ModelicaParser.Component_scopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#component_scope}.
	 * @param ctx the parse tree
	 */
	void exitComponent_scope(ModelicaParser.Component_scopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#function_call_args}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call_args(ModelicaParser.Function_call_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#function_call_args}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call_args(ModelicaParser.Function_call_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arguments(ModelicaParser.Function_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arguments(ModelicaParser.Function_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#function_arguments_non_first}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arguments_non_first(ModelicaParser.Function_arguments_non_firstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#function_arguments_non_first}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arguments_non_first(ModelicaParser.Function_arguments_non_firstContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#array_arguments}.
	 * @param ctx the parse tree
	 */
	void enterArray_arguments(ModelicaParser.Array_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#array_arguments}.
	 * @param ctx the parse tree
	 */
	void exitArray_arguments(ModelicaParser.Array_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#array_arguments_non_first}.
	 * @param ctx the parse tree
	 */
	void enterArray_arguments_non_first(ModelicaParser.Array_arguments_non_firstContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#array_arguments_non_first}.
	 * @param ctx the parse tree
	 */
	void exitArray_arguments_non_first(ModelicaParser.Array_arguments_non_firstContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#named_arguments}.
	 * @param ctx the parse tree
	 */
	void enterNamed_arguments(ModelicaParser.Named_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#named_arguments}.
	 * @param ctx the parse tree
	 */
	void exitNamed_arguments(ModelicaParser.Named_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void enterNamed_argument(ModelicaParser.Named_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void exitNamed_argument(ModelicaParser.Named_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void enterFunction_argument(ModelicaParser.Function_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#function_argument}.
	 * @param ctx the parse tree
	 */
	void exitFunction_argument(ModelicaParser.Function_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#function_partial_application}.
	 * @param ctx the parse tree
	 */
	void enterFunction_partial_application(ModelicaParser.Function_partial_applicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#function_partial_application}.
	 * @param ctx the parse tree
	 */
	void exitFunction_partial_application(ModelicaParser.Function_partial_applicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(ModelicaParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(ModelicaParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#array_subscripts}.
	 * @param ctx the parse tree
	 */
	void enterArray_subscripts(ModelicaParser.Array_subscriptsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#array_subscripts}.
	 * @param ctx the parse tree
	 */
	void exitArray_subscripts(ModelicaParser.Array_subscriptsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#subscript}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(ModelicaParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#subscript}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(ModelicaParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(ModelicaParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(ModelicaParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModelicaParser#description_string}.
	 * @param ctx the parse tree
	 */
	void enterDescription_string(ModelicaParser.Description_stringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModelicaParser#description_string}.
	 * @param ctx the parse tree
	 */
	void exitDescription_string(ModelicaParser.Description_stringContext ctx);
}