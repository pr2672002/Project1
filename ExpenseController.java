import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping
    public String getAllExpenses(Model model) {
        List<Expense> expenses = expenseRepository.findAllByOrderByCreatedAtDesc();
        model.addAttribute("expenses", expenses);
        return "expenses";
    }

    @PostMapping("/add")
    public String addExpense(@RequestParam String category, @RequestParam Double amount, @RequestParam(required = false) String comments) {
        Expense expense = new Expense();
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setComments(comments);
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @PostMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, @RequestParam String category, @RequestParam Double amount, @RequestParam(required = false) String comments) {
        Expense expense = expenseRepository.findById(id).orElseThrow();
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setComments(comments);
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }
}
