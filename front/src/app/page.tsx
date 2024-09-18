"use client";

import {useEffect, useState} from "react";
import axios from "axios";
import {Box, Button, List, ListItem, ListItemText, TextField} from "@mui/material";

export default function Home() {
    const [search, setSearch] = useState("");
    const [recipes, setRecipes] = useState([]);
    const [savedRecipes, setSavedRecipes] = useState([]);
    const [form, setForm] = useState({
        id: null,
        name: "",
        preparationTime: "",
        approximateCost: "",
        ingredients: [{ name: "" }]
    });

    const fetchSavedRecipes = async () => {
        try {
            const response = await axios.get("http://localhost:8080/revenue");
            setSavedRecipes(response.data);
        } catch (error) {
            console.error("Erro ao buscar receitas salvas:", error);
        }
    };

    useEffect(() => {
        fetchSavedRecipes();
    }, []);

    const handleSearchChange = (e) => {
        setSearch(e.target.value);
    };

    const handleFormChange = (e) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value
        });
    };

    const handleIngredientChange = (index, e) => {
        const newIngredients = [...form.ingredients];
        newIngredients[index][e.target.name] = e.target.value;
        setForm({
            ...form,
            ingredients: newIngredients
        });
    };

    const handleAddIngredient = () => {
        setForm({
            ...form,
            ingredients: [...form.ingredients, { name: "" }]
        });
    };

    const handleSave = async () => {
        const updatedForm = {
            ...form,
            ingredients: form.ingredients.map(ingredient => ({
                ...ingredient,
                idRevenue: form.id
            }))
        };

        try {
            if (form.id) {
                await axios.put(`http://localhost:8080/revenues/update/${form.id}`, updatedForm);
            } else {
                await axios.post("http://localhost:8080/revenues/create", updatedForm);
            }

            fetchSavedRecipes();

            setForm({
                id: null,
                name: "",
                preparationTime: "",
                approximateCost: "",
                ingredients: [{ name: "" }]
            });
        } catch (error) {
            console.error("Erro ao salvar a receita:", error);
        }
    };

    const handleSelectRecipe = (recipe) => {
        setForm({
            id: recipe.id,
            name: recipe.name,
            preparationTime: recipe.preparationTime,
            approximateCost: recipe.approximateCost,
            ingredients: recipe.ingredients.map(ingredient => ({
                name: ingredient.name,
                idRevenue: recipe.id
            }))
        });
    };

    const handleCancel = () => {
        setForm({
            id: null,
            name: "",
            preparationTime: "",
            approximateCost: "",
            ingredients: [{ name: "" }]
        });
    };

    const handleUpdate = async () => {
        const updatedForm = {
            ...form,
            ingredients: form.ingredients.map(ingredient => ({
                ...ingredient,
                idRevenue: form.id
            }))
        };

        try {
            await axios.put(`http://localhost:8000/update/${form.id}`, updatedForm);
            fetchSavedRecipes();
            handleCancel();
        } catch (error) {
            console.error("Erro ao atualizar a receita:", error);
        }
    };

    const handleDelete = async () => {
        try {
            await axios.delete(`http://localhost:8000/delete/${form.id}`);
            fetchSavedRecipes();
            handleCancel();
        } catch (error) {
            console.error("Erro ao excluir a receita:", error);
        }
    };

    const filteredRecipes = recipes.filter(recipe =>
        recipe.name.toLowerCase().includes(search.toLowerCase())
    );

    return (
        <div>
            <main>
                <TextField
                    id="search"
                    label="Buscar Receita"
                    variant="outlined"
                    value={search}
                    onChange={handleSearchChange}
                    fullWidth
                    margin="normal"
                />

                <List>
                    {filteredRecipes.map((recipe, index) => (
                        <ListItem key={index} button onClick={() => handleSelectRecipe(recipe)}>
                            <ListItemText primary={recipe.name} />
                        </ListItem>
                    ))}
                </List>

                <h2>Receitas Salvas</h2>
                <List>
                    {savedRecipes.map((recipe, index) => (
                        <ListItem key={index} button onClick={() => handleSelectRecipe(recipe)}>
                            <ListItemText
                                primary={recipe.name}
                                secondary={`Tempo de Preparo: ${recipe.preparationTime} | Custo Aproximado: ${recipe.approximateCost}`}
                            />
                        </ListItem>
                    ))}
                </List>

                <Box component="form" noValidate autoComplete="off">
                    <Box display="flex" gap="10px" marginBottom="16px">
                        <TextField
                            id="name"
                            name="name"
                            label="Nome"
                            variant="outlined"
                            value={form.name}
                            onChange={handleFormChange}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            id="preparationTime"
                            name="preparationTime"
                            label="Tempo de Preparo"
                            variant="outlined"
                            value={form.preparationTime}
                            onChange={handleFormChange}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            id="approximateCost"
                            name="approximateCost"
                            label="Custo Aproximado"
                            variant="outlined"
                            value={form.approximateCost}
                            onChange={handleFormChange}
                            fullWidth
                            margin="normal"
                        />
                    </Box>

                    {form.ingredients.map((ingredient, index) => (
                        <Box key={index} display="flex" gap={2}>
                            <TextField
                                id={`ingredient-name-${index}`}
                                name="name"
                                label={`Ingrediente ${index + 1}`}
                                variant="outlined"
                                value={ingredient.name}
                                onChange={(e) => handleIngredientChange(index, e)}
                                fullWidth
                                margin="normal"
                            />
                        </Box>
                    ))}

                    <Button
                        variant="outlined"
                        color="secondary"
                        onClick={handleAddIngredient}
                        style={{ marginBottom: '1rem' }}
                    >
                        Adicionar Ingrediente
                    </Button>

                    <Box display="flex" gap="10px" marginTop="16px">
                        <Button
                            variant="outlined"
                            color="default"
                            onClick={handleCancel}
                        >
                            Cancelar
                        </Button>
                        <Button
                            variant="contained"
                            color="primary"
                            onClick={form.id ? handleUpdate : handleSave}
                        >
                            {form.id ? "Atualizar" : "Salvar"}
                        </Button>
                        {form.id && (
                            <Button
                                variant="outlined"
                                color="error"
                                onClick={handleDelete}
                            >
                                Excluir
                            </Button>
                        )}
                    </Box>
                </Box>
            </main>
        </div>
    );
}
