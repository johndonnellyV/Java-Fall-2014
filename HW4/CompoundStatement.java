/**
 * collection of statements
 * @author Jack Donnelly
 */
public class CompoundStatement extends Statements
{
  /**
   * Used to store the array of statements for use in methods
   */
  public Statements[] ops;
  /**
   * constructs and executes the compound statement
   * @param ops Statements that make up the compound statement
   */
  public CompoundStatement(Statements... ops)
  {
    this.ops = ops;
    
  }
  /**
   * executes the compound statement
   * @param input state of the statements input
   */
  public void execute(State input)
  {
    for (int i = 0; i < ops.length; i++)
    {
      ops[i].execute(input);
    }
  }
  /**
   * converts it to a string representation
   * @return Returns a string of the compound statement
   */
  public String toString()
  {
    String str;
    str = "{" + '\n';
    String n = "";
    for (int i = 0; i < 1; i++)
    {
      n = n + '\t';
    }
    for (int i = 0; i < ops.length; i++)
    {
      str += ops[i].toStringTabbed(1) + '\n';
    }
    str += "}";
    return str;
  }
  /**
   * converts it to a string representation thats tabbed
   * @param input # of tabs wanted
   * @return Returns a string of the compound statement with tabs requested
   */
  public String toStringTabbed(int input)
  {
    String str;
    //used to keep track of how many indents are used
    String n = "";
    //simple loop increases until it hits the tab number
    for (int i = 0; i < input; i++)
    {
      n = n + '\t';
    }
    
    String m = "";
    //simple loop increases until it hits the tab number - 1
    for (int k = 0; k < input - 1; k++)
    {
      m = m + '\t';
    }
    
    str = '\t' + "{" + '\n';
    //simple loop increases until it hits the lenght of the array
    for (int i = 0; i < ops.length; i++)
    {
      str += '\t' + ops[i].toStringTabbed(1) + '\n';
    }
    str += '\t' + "}";
    return str;
  }
  
}